package it.presentation.servlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/grafico")
public class QuestionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private int si = 0;
	private int no = 0;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("image/png");
		try (OutputStream os = response.getOutputStream()) {
			// leggo i parametri dalla jsp
			String voto = request.getParameter("voto");
			if (voto != null) {
				if (voto.equals("si")) {
					si++;
				}
				if (voto.equals("no")) {
					no++;
				}
				if (voto.equals("reset")) {
					no = 0;
					si = 0;
				}
				if (voto.equals("six")) {
					si += 100;
				}
				if (voto.equals("nox")) {
					no += 100;
				}
				if (voto.equals("both")) {
					no++;
					si++;
				}
			}
			// crea l'immagine
			BufferedImage img = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
			Graphics g = img.createGraphics();
			// cancella lo sfondo, sarebbe nero ed inguardabile :(
			g.setColor(Color.lightGray);
			//dimensione "immagine"
			g.fillRect(0, 0, img.getWidth(), img.getHeight());
			// calcola le percentuali basandosi sui dati in ingresso e le variabili di prima
			int percSi = 0;
			int percNo = 0;
			if (si + no > 0) {
				percSi = 100 * si / (si + no);
				percNo = 100 * no / (si + no);
			}
			//disegna l'istogramma (rosso in questo caso)
			//mostrare i SI nell'immagine, prima si setta di che colore sarà l'istogramma da "renderizzare"
			g.setColor(Color.GREEN);
			g.fillRect(30, 150 - percSi, 50, percSi);
			//mostrare i NO nell'immagine
			g.setColor(Color.RED);
			g.fillRect(130, 150 - percNo, 50, percNo);
			//colori di si e no
			g.setColor(Color.BLACK);
			//scrive "si", "no" e gli da le coordinate
			g.drawString("% Sì", 40, 170);
			g.drawString("% No", 145, 170);
			// invia l'immagine in output
			ImageIO.write(img, "png", os);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
}