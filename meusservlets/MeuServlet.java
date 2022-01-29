package meusservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/MeuServlet")
public class MeuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MeuServlet() {
        super();
    }

    // Aqui � recebida a requisi��o
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// Aqui � criado um List de Strings como exemplo
    	List<String> tecnologias = new ArrayList<String>();
		tecnologias.add("Java");
		tecnologias.add("Servlet");
		tecnologias.add("React");
		tecnologias.add("Axios");
		
		// Aqui nosso List � convertido para json
		String tecnologiasJson = new Gson().toJson(tecnologias);
		
		// Aqui nossa resposta � configurada e nela adicionado nosso json 
		PrintWriter printWriter = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		printWriter.write(tecnologiasJson);
		printWriter.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
