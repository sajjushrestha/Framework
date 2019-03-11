package reporting;

public class Result {
	
	private Status result;
	private String resultText;
	private String resultScreenshot;
	
	public Result(Status result,String resultText, String resultScreenshot) {	
		this.result = result;
		this.resultText = resultText;
		this.resultScreenshot = resultScreenshot;
	}
	
	public void setResult(Status result) {
		this.result = result;
	}
	
	public Status getResult() {
		return this.result;
	}
	
	public void setResultText(String resultText) {
		this.resultText = resultText;
	}
	
	public String getResultText() {
		return this.resultText;
	}
	
	public void setResultScreenshot(String resultScreenshot) {
		this.resultScreenshot = resultScreenshot;
	}
	
	public String getResultScreenshot() {
		return this.resultScreenshot;
	}
}