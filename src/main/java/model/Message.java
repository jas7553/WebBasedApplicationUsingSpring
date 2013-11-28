/**
 * @author Jason A Smith <jas7553>
 */
package model;

/**
 * A model used to represent a message.
 */
public class Message {

	private String contents;

	public Message(String contents) {
		this.contents = contents;
	}

	public String getMessage() {
		return contents;
	}

	public void setMessage(String contents) {
		this.contents = contents;
	}

}
