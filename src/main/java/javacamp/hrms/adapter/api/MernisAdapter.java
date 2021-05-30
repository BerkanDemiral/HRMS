package javacamp.hrms.adapter.api;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import javacamp.hrms.adapter.service.VerifyApiService;
import javacamp.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisAdapter implements VerifyApiService<Candidate> {

	@Override
	public boolean apiControl(Candidate candidate) {
		KPSPublicSoapProxy kpsPublicSoapProxy;
		try {
			kpsPublicSoapProxy = new KPSPublicSoapProxy();
			boolean result = kpsPublicSoapProxy.TCKimlikNoDogrula(Long.parseLong(candidate.getIdentityNumber()),
					candidate.getFirstName().toUpperCase(), candidate.getLastName().toUpperCase(),
					Integer.parseInt(candidate.getBirthDate()));
			return result;
		} catch (RemoteException | NumberFormatException e1) {
			e1.printStackTrace();
		}
		return false;
	}

}
