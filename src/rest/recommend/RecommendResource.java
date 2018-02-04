package rest.recommend;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;



/**
 * Gateway resource for Recombee API. Takes client query for recommendations and
 * transforms them to Recombee Query Language (REQL).
 * 
 * Currently supports user-based and item-based recommendations.
 * 
 * @author ivan
 *
 */
@Stateless 
@LocalBean 
@Path("/recommend")
public class RecommendResource {

    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    
    private static final Logger logger =
            Logger.getLogger(RecommendResource.class.getName());
    
    
    /**
     * Get simple user-based recommendations.
     * 
     * @param userId target chatid of the user
     * @param count number of recommendations
     * @return list of items id
     */
    @GET
    @Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
    @Path("{userId}")
    public List<String> getRecommendationByUserId(@PathParam("userId") int userId, int count) {
        return null;
    }
    
    /**
     * Get simple item-based recommendations.
     * 
     * @param itemId if the given item
     * @param count number of recommendations
     * @return list of items id
     */
    @GET
    @Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
    @Path("{itemId}")
    public List<String> getRecommendationByItemId(@PathParam("itemId") int itemId, int count) {
        return null;
    }

    
}
