package org.pdecodts.yasb.model;

public class Channel {
	private ChannelDirection  direction ;
	private String name ;
	/**
	 * @return the direction
	 */
	public ChannelDirection getDirection() {
		return direction;
	}
	/**
	 * @param direction the direction to set
	 */
	public void setDirection(ChannelDirection direction) {
		this.direction = direction;
	}
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
	
}
