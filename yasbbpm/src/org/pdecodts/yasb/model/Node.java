package org.pdecodts.yasb.model;

import java.util.ArrayList;
import java.util.List;

import org.pdecodts.yasb.engine.ProcessingContext;

public abstract class Node {
    private String name;
    private BusinessProcess businessProcess;
    private List<Transition> incomingTransitions = new ArrayList<Transition>();
    private List<Transition> ougoingTransitions = new ArrayList<Transition>();

    /**
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * @return the businessProcess
     */
    public BusinessProcess getBusinessProcess() {
	return businessProcess;
    }

    /**
     * @param businessProcess
     *            the businessProcess to set
     */
    public void setBusinessProcess(BusinessProcess businessProcess) {
	this.businessProcess = businessProcess;
    }

    /**
     * @return the incomingTransitions
     */
    public List<Transition> getIncomingTransitions() {
	return incomingTransitions;
    }

    /**
     * @param incomingTransitions
     *            the incomingTransitions to set
     */
    public void setIncomingTransitions(List<Transition> incomingTransitions) {
	this.incomingTransitions = incomingTransitions;
    }

    /**
     * @return the ougoingTransitions
     */
    public List<Transition> getOugoingTransitions() {
	return ougoingTransitions;
    }

    /**
     * @param ougoingTransitions
     *            the ougoingTransitions to set
     */
    public void setOugoingTransitions(List<Transition> ougoingTransitions) {
	this.ougoingTransitions = ougoingTransitions;
    }

    protected abstract boolean isMulitleIncomingTransitionSupported();

    protected abstract boolean isMulitleOutgoingTransitionSupported();

    protected abstract boolean isWaitingNode();

    protected abstract boolean isRequiredEvaluation();

    /**
     * @param ctx
     * @return
     */
    public NodeState start(ProcessingContext ctx) {
	// TODO Auto-generated method stub
	return NodeState.WaitingState;
    }

}
