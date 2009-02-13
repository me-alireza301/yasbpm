/**
 * 
 */
package org.pdecodts.yasbpm.model.activity;

import org.pdecodts.yasbpm.model.processmodel.Role;

/**
 * @author xsipds
 *
 */
public class HumanActivity {
    public Role requiredRole ;

    public Role getRequiredRole() {
        return requiredRole;
    }

    public void setRequiredRole(Role requiredRole) {
        this.requiredRole = requiredRole;
    }
    
}
