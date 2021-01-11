package com.ubot.application.controller;

import com.ubot.application.exception.InvalidDataException;
import com.ubot.application.exception.MSGException;
import com.ubot.application.service.AdBorderDAO;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Jenny
 */

@Path("/")
public class AdBorderImgController  {

    //http://localhost:8080/MyMsg/adBorder_IMGServlet/619422f52445417f953c781a66ff76bf
    private static final long serialVersionUID = 1L;

    @GET
    @Path("/adBorder_IMGServlet/{uuid}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    
    public Response AdBorder_IMGServlet_res(@PathParam("uuid") String uuid) {
       byte[] stringAdBorderImgMap=null;
       List<String> errors = new ArrayList<>();
        try {
            AdBorderDAO adBorderDAO = new AdBorderDAO();
            stringAdBorderImgMap = adBorderDAO.selectImg(uuid);
        } catch (InvalidDataException ex) {
            errors.add("查詢失敗" + ex.getMessage());
        } catch (MSGException ex) {
            Logger.getLogger(AdBorderImgController.class.getName()).log(Level.WARNING, ex.getMessage(), ex);
            errors.add("查詢失敗" + ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(AdBorderImgController.class.getName()).log(Level.WARNING, ex.getMessage(), ex);
            errors.add("查詢失敗" + ex.getMessage());
        }
        System.out.println(errors);
        return Response.ok(stringAdBorderImgMap).build();
    }
}
