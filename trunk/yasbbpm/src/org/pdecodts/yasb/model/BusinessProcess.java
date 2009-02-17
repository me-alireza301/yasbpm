package org.pdecodts.yasb.model;

import java.util.ArrayList;
import java.util.List;

public class BusinessProcess {

	
	private String name ;
	private Object id ;
	private ArrayList<Transition> transitions =  new ArrayList<Transition>() ;
	private ArrayList<Node> nodes =  new ArrayList<Node>() ;
	
	private ArrayList<Node> startNodes = new ArrayList<Node>() ;
	private ArrayList<Channel> inputChannel  = new ArrayList<Channel> () ;
	private ArrayList<Channel> outputChannel  = new ArrayList<Channel> () ;
	
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @return the id
	 */
	public Object getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(Object id) {
		this.id = id;
	}



	/**
	 * @return the transitions
	 */
	public ArrayList<Transition> getTransitions() {
		return transitions;
	}



	/**
	 * @param transitions the transitions to set
	 */
	public void setTransitions(ArrayList<Transition> transitions) {
		this.transitions = transitions;
	}

	public void addTransition(Transition aTransition )
	{
		//Precondition
		// @TODO AssetNotNull(aTransition) 
		// @TODO AseertNull( !this.transitions.contains(aTransition) 
		
		this.transitions.add(aTransition) ;
	}
	
	

	
	public Transition findTransition(String name) {
		Transition aTransition =  new Transition ( ) ;
		Transition res = null  ;
		aTransition.setName  (name ) ;
		for (Transition trans : this.transitions) {
			if (aTransition.equals(trans)) {
			res = trans ;
			break ; 
			}
		}
		return res ;
	}
	/**
	 * @return the nodes
	 */
	public ArrayList<Node> getNodes() {
		return nodes;
	}



	/**
	 * @param nodes the nodes to set
	 */
	public void setNodes(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}

	
	public void addNode(Node aNode) {
		//Precondition
		// @TODO AssetNotNull(aNode) 
		// @TODO AseertNull( !this.transitions.contains(aNode) 
		
		this.nodes.add(aNode) ;
	}



	/**
	 * @return the startNodes
	 */
	public ArrayList<Node> getStartNodes() {
		return startNodes;
	}



	/**
	 * @param startNodes the startNodes to set
	 */
	public void setStartNodes(ArrayList<Node> startNodes) {
		this.startNodes = startNodes;
	}


	public void addStartNode(Node aNode) {
		//Precondition
		// @TODO AssetNotNull(aNode) 
		// @TODO AseertNull( !this.startNodes.contains(aNode) 
		
		this.startNodes.add(aNode) ;
		this.addNode(aNode) ;
	}

	/**
	 * @return the inputChannel
	 */
	public ArrayList<Channel> getInputChannel() {
		return inputChannel;
	}



	/**
	 * @param inputChannel the inputChannel to set
	 */
	public void setInputChannel(ArrayList<Channel> inputChannel) {
		this.inputChannel = inputChannel;
	}



	/**
	 * @return the outputChannel
	 */
	public ArrayList<Channel> getOutputChannel() {
		return outputChannel;
	}



	/**
	 * @param outputChannel the outputChannel to set
	 */
	public void setOutputChannel(ArrayList<Channel> outputChannel) {
		this.outputChannel = outputChannel;
	}



	public void addChannel (Channel aChannel) {
		List<Channel> target = null ;
		if(aChannel.getDirection()  == ChannelDirection.Input ){
			target = inputChannel ;
		}
		if(aChannel.getDirection() == ChannelDirection.Output) {
			target = outputChannel ;
		}
		
		
		//Precondition
		// @TODO assertNotNull(target) :
		if (!target.contains (aChannel) ) {
			target.add(aChannel) ;
		}
	}



	
	
	
	
}
