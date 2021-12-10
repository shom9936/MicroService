package util;

public class ActionForward {

	private String nextPath; //
	private boolean redirect;//true - redirect , false - Forward;
	public ActionForward(String nextPath, boolean redirect) {
		super();
		this.nextPath = nextPath;
		this.redirect = redirect;
	}
	public String getNextPath() {
		return nextPath;
	}
	public void setNextPath(String nextPath) {
		this.nextPath = nextPath;
	}
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}

	
	
	
}
