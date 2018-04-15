import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class RequestBody {
	public int length;
	public int width;
	public int height;
	public String size;
}
