package org.oz.sppol.service.common.user;

import org.oz.sppol.bo.common.user.FwkUserBO;
import org.oz.sppol.dao.common.user.FwkUserDAO;

/**
 * Created by WIN on 5/17/2017.
 */
public class FwkUserServiceImpl implements FwkUserService {

    private FwkUserDAO fwkUserDAO;
    public void setFwkUserDAO(FwkUserDAO fwkUserDAO) {
        this.fwkUserDAO = fwkUserDAO;
    }

    @Override
    public int  validate(String ahsFrameWork, String userName, String pswd, String msg) {

            int userId = fwkUserDAO.usernameExist(ahsFrameWork,userName);

            if(userId == -1 )
            {
                msg = "Invalid username/password.";
            }
        FwkUserBO fwkUserBO = fwkUserDAO.getFwkUserDetails(ahsFrameWork,userId);
        if(fwkUserBO.getuserId() > 0 && fwkUserBO.isActive() && fwkUserBO.getDecryptedPassword().equals(pswd))
        {
            return  userId;
        }
        else
        {
            msg = "Invalid username/password.";
            return -1;  // indicating error
        }

    }


}
