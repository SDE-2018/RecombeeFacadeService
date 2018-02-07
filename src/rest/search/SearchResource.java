package rest.search;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

/**
 * TODO!
 * @author ivan
 *
 */
@Stateless 
@LocalBean 
@Path("/search")
public class SearchResource {

    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    
    private static final Logger logger =
            Logger.getLogger(SearchResource.class.getName());
    

}
