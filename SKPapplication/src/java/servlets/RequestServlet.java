/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.GoIndex;
import model.PnsSkp;
import model.TupoksiKeIsi4Faktor;
import model.unorskp;

/**
 *
 * @author Andez
 */
public class RequestServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // controller untuk halaman
        String page = request.getParameter("page");
        String jenis_tambahan = request.getParameter("jenis_tambahan");
        String page1 = request.getParameter("page1");
        if (page == null) {
            page = page1;
            if (page1 == null) {
                cetakNotAvailable(response);
            } else {
                page = "/WEB-INF/jsp/" + page + ".jsp";
                try {
                    RequestDispatcher rd = request.getRequestDispatcher(page);
                    rd.forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                    cetakNotAvailable(response);
                }
            }


        } else {
            if (page.equalsIgnoreCase("validasi")) {
                if (request.getParameter("jenis_tambahan").toString().equals("Keterampilan")) {
                    PrintWriter out = response.getWriter();
                    out.print("<select name='koef_kreatifitas'><option value='10'>Unit Organisasi</option><option value='20'>Instansi</option><option value='30'>Nasional</option> </select>");
                    out.close();
                }
            }
            if (page.equalsIgnoreCase("validasi_unor")) {
                ModelLocatorSKP.arraypGcavernip = new ArrayList<String>();
                //    unorskp Unorskp = new GoIndex().getIdUnorskp(jenis_tambahan);
                //    String iUnorTambahan =Unorskp.getDiAtasanId();

                List<PnsSkp> pnsList = new GoIndex().getTugasTambahanBawahanListALL(jenis_tambahan);
                request.setAttribute("pnsList", pnsList);
                PrintWriter out = response.getWriter();
                StringBuilder sb = new StringBuilder();
                String warna = "b";
                for (int i = 0; i < pnsList.size(); i++) {
                    if (warna.equals("b")) {
                        sb.append("<tr style ='background: #7FFFD4'>"
                                + "<td width='30' align='center'>" + (i + 1) + "</td>"
                                + "<td width='100'><div align='left'><a href='GetPnsServlet?action=Monitor&txtNIPBaru='" + pnsList.get(i).getNipBaru() + ">" + pnsList.get(i).getNipBaru() + "</a></div></td>"
                                + "  <td width ='100'><div align='left'><a href='GetPnsServlet?action=Monitor&txtNIPBaru='" + pnsList.get(i).getNipBaru() + ">" + pnsList.get(i).getNamaPns() + "</a></div></td>"
                                + "  <td width ='250'><div align='left'>" + pnsList.get(i).getNamaJabatan() + "</div></td>"
                                + "</tr>");
                         warna="c";
                    } else {
                        sb.append("<tr style='background: #ADFF2F'>"
                                + "<td width='30' align='center'>" + (i + 1) + "</td>"
                                + "<td width='100'><div align='left'><a href='GetPnsServlet?action=Monitor&txtNIPBaru='" + pnsList.get(i).getNipBaru() + ">" + pnsList.get(i).getNipBaru() + "</a></div></td>"
                                + "  <td width ='100'><div align='left'><a href='GetPnsServlet?action=Monitor&txtNIPBaru='" + pnsList.get(i).getNipBaru() + ">" + pnsList.get(i).getNamaPns() + "</a></div></td>"
                                + "  <td width ='250'><div align='left'>" + pnsList.get(i).getNamaJabatan() + "</div></td>"
                                + "</tr>");
                        warna = "b";
                    }
                }
                out.print("<table  width='500'>");

                out.print("<tr>");
                out.print("<td width ='30'>No.</td>");
                out.print("<td  width ='100' >NIP BARU</td>");
                out.print("<td width ='100' >NAMA</td>");
                 out.print("<td width ='250' >JABATAN</td>");
                out.print("</tr>");
                out.print("<tr>");
                out.print(sb);
                out.print("</tr>");
                out.print("</table>");
                out.close();
            } else {
                if (ModelLocatorSKP.levelUser.equals("3") || ModelLocatorSKP.levelUser.equals("2")) {
                    page = "navigasiPenggunadat";
                    PnsSkp pns = new GoIndex().getPns(ModelLocatorSKP.loginNipsession);
                    if (pns == null) {
                    } else {
                        String unorAtasan;
                        PnsSkp UnorAts;
                        unorAtasan = pns.getDiAtasanId();
                        String UnorPns = pns.getUnorId();
                        if (unorAtasan.equals("")) {
                            unorAtasan = pns.getUnorId();
                        } else {
                            unorAtasan = pns.getDiAtasanId();
                        }
                        String InstansiPns = pns.getInstansiId();
                        String NipPns = pns.getNipBaru();

                        ModelLocatorSKP.nipBaruAtasan = NipPns;
                        ModelLocatorSKP.loginNipPengguna = NipPns;
                        ModelLocatorSKP.IdUnorUser = pns.getUnorId();

                        UnorAts = new GoIndex().getUnorAtasan(unorAtasan);
                        ModelLocatorSKP.nipBaruAtasan = UnorAts.getNipBaru();
                        if (UnorAts == null) {
                            unorskp unorAtasanLagi = new GoIndex().getIdUnorAtasan(unorAtasan);
                            String namaUnorAtasNyaLagi = unorAtasanLagi.getNamaUnor();
                            String IdUnorAtasNyaLagi = unorAtasanLagi.getDiAtasanId();

                            String UnorAtasanAtasan = new GoIndex().getUpdateUnorYangKosong(NipPns, IdUnorAtasNyaLagi);
                            unorAtasan = pns.getDiAtasanId();
                            UnorAts = new GoIndex().getUnorAtasan(unorAtasan);
                            ModelLocatorSKP.nipBaruAtasan = UnorAts.getNipBaru();
                        }

                        List<TupoksiKeIsi4Faktor> tukesiServlet = new GoIndex().getTukesi(UnorPns, InstansiPns, NipPns);
                        request.setAttribute("pns", pns);
                        request.setAttribute("UnorAts", UnorAts);
                        request.setAttribute("tukesiServlet", tukesiServlet);
                        request.setAttribute("tingkatPengguna", ModelLocatorSKP.levelUser);
                        ModelLocatorSKP.navigasiPil = "0";

                        request.setAttribute("navigasiPilihan", ModelLocatorSKP.navigasiPil);


                    }
                }
                page = "/WEB-INF/jsp/" + page + ".jsp";
                try {
                    RequestDispatcher rd = request.getRequestDispatcher(page);
                    rd.forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                    cetakNotAvailable(response);
                }
            }
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void cetakNotAvailable(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<HTML><HEAD><TITLE>SKP</TITLE>"
                + "</HEAD><BODY>Maaf anda tidak dapat mengakses halaman ini. Klik <a href='"
                + "/SKPapplication"
                + "'>link ini </a> untuk kembali</BODY></HTML>");
        out.close();
    }
}
