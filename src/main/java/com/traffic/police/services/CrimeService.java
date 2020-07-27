package com.traffic.police.services;


import com.traffic.police.models.CrimeDescriptionEntity;
import com.traffic.police.models.OffencesEntity;
import com.traffic.police.repos.CrimeRepo;
import com.traffic.police.repos.OffencesRepo;
import com.traffic.police.utils.GeneralRequest;
import com.traffic.police.utils.GeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;


@Service
public class CrimeService {
    @Autowired
    CrimeRepo crimeRepo;
    @Autowired
    OffencesRepo offencesRepo;
    GeneralResponse response;

    private static String getRadom(int size) {
        if (size <= 1) {
            return null;
        }
        Random rad = new Random();
        String output = "";
        for (int i = 0; i < size; i++) {
            output += rad.nextInt(9);
        }
        return output;

    }

    public GeneralResponse getUserOffences(GeneralRequest<CrimeDescriptionEntity> generalRequest) {
        response = new GeneralResponse();
        CrimeDescriptionEntity crime = generalRequest.getPayload();
        CrimeDescriptionEntity offence = null;
        System.out.println("Case Number: " + crime.getCasenumber());
        CrimeDescriptionEntity descritionEntity = new CrimeDescriptionEntity();
        try {
            offence = crimeRepo.findByCasenumber(crime.getCasenumber());
            response.setRequestStatus(true);
            if (offence != null) {
                if (offence.getOffencestatus().equalsIgnoreCase("Paid") || offence.getOffencestatus().equalsIgnoreCase("Closed")) {
                    response.setMessage("Case is closed or already paid");
                    response.setHttpStatus(HttpStatus.OK);
                    response.setPayload(null);
                } else {
                    response.setMessage("Success");
                    response.setHttpStatus(HttpStatus.OK);
                    response.setPayload(offence);
                }

            } else {
                response.setMessage("Not Found");
                response.setHttpStatus(HttpStatus.OK);
                response.setPayload(null);

            }
        } catch (Exception exception) {
            response.setRequestStatus(false);
            response.setMessage("An Error occurred");
            response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
            response.setPayload(null);
        }
        return response;
    }

    public GeneralResponse fetchAllCases(GeneralRequest<CrimeDescriptionEntity> generalRequest) {
        response = new GeneralResponse();
        try {
            response.setRequestStatus(true);
            response.setMessage("Success");
            response.setHttpStatus(HttpStatus.OK);
            response.setPayload(crimeRepo.findAll());
        } catch (Exception exception) {
            response.setRequestStatus(false);
            response.setMessage("An Error occurred");
            response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
            response.setPayload(null);
        }
        return response;
    }

    public GeneralResponse createCrime(GeneralRequest<CrimeDescriptionEntity> generalRequest) {
        response = new GeneralResponse();
        CrimeDescriptionEntity crime = generalRequest.getPayload();
        CrimeDescriptionEntity descritionEntity = new CrimeDescriptionEntity();
        String casenumber = new StringBuilder().append("5321").append(getRadom(2)).toString();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
        Calendar calendar=Calendar.getInstance();
        try {
            OffencesEntity amount = offencesRepo.findByOffenceid(crime.getOffence());
            descritionEntity.setCasenumber(casenumber);
            descritionEntity.setCrime(amount.getOffencedescription());
            descritionEntity.setExpirydate(date);
            descritionEntity.setOffencedate(date);
            descritionEntity.setLicensenumber(crime.getLicensenumber());
            descritionEntity.setOffernderidnumber(crime.getOffernderidnumber());
            descritionEntity.setOffenceamount(amount.getOffenceamount());
            descritionEntity.setIssuerofficer(crime.getIssuerofficer());
            descritionEntity.setOffernderidnumber(crime.getOffernderidnumber());
            descritionEntity.setOffencestatus("Open");
            descritionEntity.setVehiclenumber(crime.getVehiclenumber());
            descritionEntity.setOffencelocation(crime.getOffencelocation());
            descritionEntity.setMobilenumber(crime.getMobilenumber());
            crimeRepo.save(descritionEntity);
            response.setRequestStatus(true);
            response.setMessage("Success");
            response.setHttpStatus(HttpStatus.ACCEPTED);
            response.setPayload(descritionEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            response.setRequestStatus(false);
            response.setMessage("An Error occurred");
            response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
            response.setPayload(null);
        }
        return response;
    }
}
