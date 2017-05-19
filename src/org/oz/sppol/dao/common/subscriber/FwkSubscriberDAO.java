package org.oz.sppol.dao.common.subscriber;

import org.oz.sppol.bo.common.subscriber.FwkSubscriberBO;

/**
 * Created by WIN on 5/17/2017.
 */
public interface FwkSubscriberDAO {
    public int getSubscriberId(String ashFrameWork, String companyName);
    public FwkSubscriberBO getSubscriberDetails(String ashFrameWork, int id);
}
