/**
 * 
 */
package org.pdecodts.yasbpm.model.processmodel;

/**
 * @author xsipds
 *
 */
public class Transition {
    private String name ;
    private Node input ;
    private Node ouput ;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Node getInput() {
        return input;
    }
    public void setInput(Node input) {
        this.input = input;
    }
    public Node getOuput() {
        return ouput;
    }
    public void setOuput(Node ouput) {
        this.ouput = ouput;
    }
    
    
}
