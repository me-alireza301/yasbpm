package org.pdecodts.yasb.engine;

import java.util.ArrayList;

import org.pdecodts.yasb.model.BusinessProcess;
import org.pdecodts.yasb.model.Node;


public class BusinessProcessInstance {
	private BusinessProcess model ;
	private ArrayList<Node> currentNodes ;
	/**
	 * @return the model
	 */
	public BusinessProcess getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(BusinessProcess model) {
		this.model = model;
	}
	/**
	 * @return the currentNodes
	 */
	public ArrayList<Node> getCurrentNodes() {
		return currentNodes;
	}
	/**
	 * @param currentNodes the currentNodes to set
	 */
	public void setCurrentNodes(ArrayList<Node> currentNodes) {
		this.currentNodes = currentNodes;
	}
	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
