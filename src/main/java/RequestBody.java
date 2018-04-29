import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class RequestBody {
	public int length;
	public int width;
	public int height;
	public String size;
	
	RequestBody() {
	}
	
	RequestBody(int l, int w, int h, String s) {
		this.length = l;
		this.width = w;
		this.height = h;
		this.size = s;
	}
}
