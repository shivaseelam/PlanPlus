package org.oz.sppol.service.common.subscriber;

import org.oz.sppol.dao.common.subscriber.FwkSubscriberDAO;
import org.oz.sppol.dto.common.subscriber.FwkSubscriberDTO;

/**
 * Created by WIN on 5/19/2017.
 */
public class FwkSubscriberServiceImpl implements FwkSubscriberService{


    public void setFwkSubscriberDAO(FwkSubscriberDAO fwkSubscriberDAO) {
        this.fwkSubscriberDAO = fwkSubscriberDAO;
    }

    private FwkSubscriberDAO fwkSubscriberDAO;
    @Override
    public boolean subscriberServiceExist(String ashFramework, String comanyName) {

       int subscriberId =  fwkSubscriberDAO.getSubscriberId("ahsWebBean",comanyName);
        if(subscriberId > 0)
        {
            return  true;
        }

        return false;
    }
}
