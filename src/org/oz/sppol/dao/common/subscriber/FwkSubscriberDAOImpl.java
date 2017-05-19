package org.oz.sppol.dao.common.subscriber;

import org.oz.sppol.bo.common.subscriber.FwkSubscriberBO;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.Types;

/**
 * Created by WIN on 5/17/2017.
 */
public class FwkSubscriberDAOImpl extends JdbcDaoSupport implements  FwkSubscriberDAO{


    private static final String SUBSCRIBER_EXIST= "SELECT SUBSCRIBER_ID FROM fwk_subscriber WHERE  ACTIVE_STATUS ='Y' AND COMPANY_NAME = ?";
    private static final String SUBSCRIBER_DETAILS_BY_ID= "SELECT SUBSCRIBER_ID,COMPANY_NAME FROM fwk_subscriber WHERE  ACTIVE_STATUS ='Y' AND SUBSCRIBER_ID = ?";
    @Override
    public int getSubscriberId(String ashFrameWork, String companyName) {

        Object[] params = { companyName};

        int[] types  ={Types.VARCHAR};
        int subscriberId = getJdbcTemplate().queryForObject(SUBSCRIBER_EXIST,params,Integer.class);
        if(subscriberId > 0 )
        {
            return subscriberId;
        }
        return  0;

    }

    @Override
    public FwkSubscriberBO getSubscriberDetails(String ashFrameWork, int id) {

        FwkSubscriberBO subscriberBO = new FwkSubscriberBO();
        Object[] params = { id};
        subscriberBO =getJdbcTemplate().queryForObject(SUBSCRIBER_DETAILS_BY_ID,params,FwkSubscriberBO.class);


        if(subscriberBO != null)
            return  subscriberBO;

        return null;
    }
}
