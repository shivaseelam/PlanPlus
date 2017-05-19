package org.oz.sppol.dao.common.user;

import org.oz.sppol.bo.common.user.FwkUserBO;

/**
 * Created by WIN on 5/17/2017.
 */
public interface FwkUserDAO {
         public int usernameExist(String AhsWebBean, String username);
         public FwkUserBO getFwkUserDetails(String AhsWebBean, int userID);
}
