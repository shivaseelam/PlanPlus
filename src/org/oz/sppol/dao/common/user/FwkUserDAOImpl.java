package org.oz.sppol.dao.common.user;

import org.oz.sppol.bo.common.user.FwkUserBO;
import org.oz.sppol.bo.customer.CustomerBO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by WIN on 5/17/2017.
 */
public class FwkUserDAOImpl extends JdbcDaoSupport implements FwkUserDAO {

    private static final String USER_EXIST= "SELECT USER_ID FROM FWK_USER WHERE  ACTIVE_STATUS ='Y' AND USER_NAME = ?";
    private static final String GET_USER_DETAILS_BY_ID= "SELECT * FROM FWK_USER WHERE  ACTIVE_STATUS ='Y' AND USER_ID = ?";

    @Override
    public int usernameExist(String AhsWebBean, String username) {

        Object[] params = { username};

        int[] types  ={Types.VARCHAR};
        int userId = getJdbcTemplate().queryForObject(USER_EXIST,params,Integer.class);
        if(userId > 0 )
        {
            return userId;
        }
        return  0;
    }

    @Override
    public FwkUserBO getFwkUserDetails(String AhsWebBean, int userID) {

        FwkUserBO usersBO = new FwkUserBO();
        Object[] params = { userID};
        usersBO =(FwkUserBO) getJdbcTemplate().queryForObject(GET_USER_DETAILS_BY_ID,params,new BeanPropertyRowMapper(FwkUserBO.class));


        if(usersBO != null)
        return  usersBO;

        return null;
    }
}
