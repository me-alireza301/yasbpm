/**
 * 
 */
package org.pdecodts.yasbpm.model.processmodel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xsipds
 *
 */
public abstract class Node {
    private String name ;
    private List<Transition> incomingTransition = new ArrayList<Transition> () ;
    private List<Transition> ougoingTransition  = new ArrayList<Transition> () ;
    
    public abstract boolean supportMultipleOutgoingTransition() ;
    public abstract boolean supportMultipleIncominTransition() ;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Transition> getIncomingTransition() {
        return incomingTransition;
    }
    public void setIncomingTransition(List<Transition> incomingTransition) {
        this.incomingTransition = incomingTransition;
    }
    public List<Transition> getOugoingTransition() {
        return ougoingTransition;
    }
    public void setOugoingTransition(List<Transition> ougoingTransition) {
        this.ougoingTransition = ougoingTransition;
    }
}
