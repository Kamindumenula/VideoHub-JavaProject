package videoHubPackage;

public class InquiryModel {
	private int inquiryID;
	private String inquiryType;
	private String inquiryMessage;
	private String phoneNumber;
	private int userID;
	
	public InquiryModel(int inquiryID, String inquiryType, String inquiryMessage, String phoneNumber,int userID) {
		super();
		this.inquiryID = inquiryID;
		this.inquiryType = inquiryType;
		this.inquiryMessage = inquiryMessage;
		this.phoneNumber = phoneNumber;
		this.userID=userID;
	}

	public int getInquiryID() {
		return inquiryID;
	}

	public void setInquiryID(int inquiryID) {
		this.inquiryID = inquiryID;
	}

	public String getInquiryType() {
		return inquiryType;
	}

	public void setInquiryType(String inquiryType) {
		this.inquiryType = inquiryType;
	}

	public String getInquiryMessage() {
		return inquiryMessage;
	}

	public void setInquiryMessage(String inquiryMessage) {
		this.inquiryMessage = inquiryMessage;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	
}