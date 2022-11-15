package com.workdatabase.util;



import com.workdatabase.resp.InfidentifyResp;

import java.io.Serializable;

public class IdentifyInfContext implements Serializable {

    private static ThreadLocal<InfidentifyResp> user = new ThreadLocal<>();

    public static InfidentifyResp getUser() {
        return user.get();
    }

    public static void setUser(InfidentifyResp user) {
        IdentifyInfContext.user.set(user);
    }

}
