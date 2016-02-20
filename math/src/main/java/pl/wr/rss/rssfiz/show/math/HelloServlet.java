package pl.wr.rss.rssfiz.show.math;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.wr.math.number.Fraction;

@SuppressWarnings("serial")
public class HelloServlet extends HttpServlet {

	public static final String HTML_START = "<html><head><meta http-equiv='Content-Type' content='text/html; charset=UTF-8'></head><body>";
	public static final String HTML_END = "</body></html>";

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();

		out.println(HTML_START);
		out.println(body());
		out.println(HTML_END);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		String operacja = request.getParameter("operacja");

		Fraction result = null;
		out.println(HTML_START);
		out.println(body());

		try {
			Long total1 = request.getParameter("total1").equals("") ? 0 : Long.valueOf(request.getParameter("total1"));
			Long total2 = request.getParameter("total2").equals("") ? 0 : Long.valueOf(request.getParameter("total2"));
			Long numerator1 = request.getParameter("numerator1").equals("") ? 0
					: Long.valueOf(request.getParameter("numerator1"));
			Long numerator2 = request.getParameter("numerator2").equals("") ? 0
					: Long.valueOf(request.getParameter("numerator2"));
			Long denominator1 = request.getParameter("denominator1").equals("") ? 1
					: Long.valueOf(request.getParameter("denominator1"));
			Long denominator2 = request.getParameter("denominator2").equals("") ? 1
					: Long.valueOf(request.getParameter("denominator2"));
			Integer decimalPower1 = request.getParameter("decimalPower1").equals("") ? 0
					: Integer.valueOf(request.getParameter("decimalPower1"));
			Integer decimalPower2 = request.getParameter("decimalPower2").equals("") ? 0
					: Integer.valueOf(request.getParameter("decimalPower2"));

			Fraction x = new Fraction(total1, numerator1, denominator1, decimalPower1);
			Fraction y = new Fraction(total2, numerator2, denominator2, decimalPower2);

			switch (operacja) {
			case "+":
				result = Fraction.add(x, y);
				break;
			case "-":
				result = Fraction.subtract(x, y);
				break;
			case "*":
				result = Fraction.multiply(x, y);
				break;
			case "/":
				result = Fraction.divide(x, y);
				break;

			default:
				break;
			}
			
			out.println("Number1: " + toString(x));
			out.println("Number2: " + toString(y));
			
			out.println("<br> result = " + result + "<br>");
			int nowe = (int) (result.getNumerator() * Math.pow(10, result.getDecimalPower())
					- result.intValue() * result.getDenominator());

			out.print("<h3>result = ");
			if (result.intValue() != 0) {
				out.print(result.intValue());
			} else {
				out.print(0);
			}
			if (nowe != 0) {
				Fraction news = new Fraction(nowe, result.getDenominator());
				out.println(" " + news.getNumerator() + "/" + news.getDenominator());
			}
			out.println("<br>" + result.doubleValue());

		} catch (Exception e) {
			out.println("Bad data");
		}

		out.println("</h3>" + HTML_END);
	}

	private String body() {
		String tekst = "<form action='Kalkulator' method='post'>" + "<fieldset>"
				+ "<input type='text' name='total1' placeholder='Total' />"
				+ "<input type='text' name='numerator1' placeholder='Numerator' />  /  "
				+ "<input type='text' name='denominator1' placeholder='Denominator' />" + "* 10 ^ "
				+ "<input type='text' name='decimalPower1' placeholder='Decimal Power' />" + "<br>"
				+ "<select name='operacja'>" + "<option>+</option>" + "<option>-</option>" + "<option>*</option>"
				+ "<option>/</option>" + "</select>" + "<br>"
				+ "<input type='text' name='total2' placeholder='Total' />"
				+ "<input type='text' name='numerator2' placeholder='Numerator' />  /  "
				+ "<input type='text' name='denominator2' placeholder='Denominator' />" + "* 10 ^ "
				+ "<input type='text' name='decimalPower2' placeholder='Decimal Power' />" + "<br>"
				+ "<input type='submit' value='Send' />" + "</fieldset>" + "</form>";
		return tekst;
	}
	public String toString(Fraction f) {
        final StringBuilder builder = new StringBuilder(32);

        builder.append(" ");
        builder.append(f.getNumerator());
        builder.append("/");
        builder.append(f.getDenominator());
        builder.append(" * 10 ^ ");
        builder.append(f.getDecimalPower());
        builder.append("<br>");
        return builder.toString();
    }
}
