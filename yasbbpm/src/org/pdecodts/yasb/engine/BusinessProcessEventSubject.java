package org.pdecodts.yasb.engine;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.pdecodts.yasb.util.Asserter;

public class BusinessProcessEventSubject {

    /**
     * class logger
     */
    private final static Log log = LogFactory
	    .getLog(BusinessProcessEvent.class);

    // -------------- Warning error codes ----------------------

    private static final Object NullBPInstanceIDWarnCode = "BPEVT-W1";;

    private static final Object NullBPModelIDWarnCode = "BPEVT-W2";;

    private static final Object NullBPModelNameWarnCode = "BPEVT-W3";;

    private static final Object NullSubjectNameWarnCode = "BPEVT-W4";;

    String businessProcessModelName;
    Object businessProcessModelId;
    Object businessProcessInstanceId;
    String subjetName;

    /**
     * @param businessProcessModelName
     *            the businee process model name
     * @param businessProcessModelId
     *            the business process model id
     * @param businessProcessInstanceId
     *            the business process instance id
     * @param subjetName
     *            the subject name
     */
    public BusinessProcessEventSubject(String businessProcessModelName,
	    Object businessProcessModelId, Object businessProcessInstanceId,
	    String subjetName) {
	super();
	this.businessProcessModelName = businessProcessModelName;
	this.businessProcessModelId = businessProcessModelId;
	this.businessProcessInstanceId = businessProcessInstanceId;
	this.subjetName = subjetName;
    }

    /**
     * @return the businessProcessModelName
     */
    public String getBusinessProcessModelName() {
	return businessProcessModelName;
    }

    /**
     * @param businessProcessModelName
     *            the businessProcessModelName to set
     */
    public void setBusinessProcessModelName(String businessProcessModelName) {
	this.businessProcessModelName = businessProcessModelName;
    }

    /**
     * @return the businessProcessModelId
     */
    public Object getBusinessProcessModelId() {
	return businessProcessModelId;
    }

    /**
     * @param businessProcessModelId
     *            the businessProcessModelId to set
     */
    public void setBusinessProcessModelId(Object businessProcessModelId) {
	this.businessProcessModelId = businessProcessModelId;
    }

    /**
     * @return the businessProcessInstanceId
     */
    public Object getBusinessProcessInstanceId() {
	return businessProcessInstanceId;
    }

    /**
     * @param businessProcessInstanceId
     *            the businessProcessInstanceId to set
     */
    public void setBusinessProcessInstanceId(Object businessProcessInstanceId) {
	this.businessProcessInstanceId = businessProcessInstanceId;
    }

    /**
     * @return the subjetName
     */
    public String getSubjetName() {
	return subjetName;
    }

    /**
     * @param subjetName
     *            the subjetName to set
     */
    public void setSubjetName(String subjetName) {
	this.subjetName = subjetName;
    }

    /**
     * Equality semantic comparator.
     * 
     * BusinessProcessEventSubject are considered equal if they are addressing
     * <ul>
     * <li>the same business process (name and id of business process model
     * should the same)</li>
     * <li>the same business process instance (business process id should be the
     * same)</li>
     * <li>the subject name should be the same</li>
     * <li></li>
     * </ul>
     * 
     * @param evt
     *            the subject to compare with
     * @return true if the subject are equals, false otherwise
     */
    public boolean equals(BusinessProcessEventSubject evt) {
	return (this.businessProcessInstanceId.equals(evt
		.getBusinessProcessInstanceId())
		&& this.businessProcessModelId.equals(evt
			.getBusinessProcessModelId())
		&& this.businessProcessModelName.equals(evt
			.getBusinessProcessModelName()) && this.subjetName
		.equals(evt.getSubjetName()));
    }

    /**
     * Check if a event subject is valid. A event subject is valid when
     * <ul>
     * <li>the related business processes instance identifier is not null</li>
     * <li>the realted business process model identifier is not null</li>
     * <li>the realted business process model name is not null</li>
     * <li>the subject name is not null</li>
     * </ul>
     * 
     * @return true if the object is valid, false otherwise
     */
    public boolean isValid() {
	return (Asserter.assertNotNull(log, this.businessProcessInstanceId,
		"businessprocess instance id is null ",
		NullBPInstanceIDWarnCode)
		&& Asserter.assertNotNull(log, this.businessProcessModelId,
			"business process model id is null ",
			NullBPModelIDWarnCode)
		&& Asserter.assertNotNull(log, this.businessProcessModelName,
			"business process model name is null ",
			NullBPModelNameWarnCode) && Asserter.assertNotNull(log,
		this.subjetName, "subject name is null ",
		NullSubjectNameWarnCode));

    }
}
