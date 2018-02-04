package rest.recommend;

import java.util.ArrayList;
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

import com.recombee.api_client.RecombeeClient;
import com.recombee.api_client.api_requests.ItemBasedRecommendation;
import com.recombee.api_client.api_requests.UserBasedRecommendation;
import com.recombee.api_client.bindings.Recommendation;
import com.recombee.api_client.exceptions.ApiException;

import recombee.client.RecombeeAPIClient;
import util.FacadeUtil;



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
    
    private RecombeeClient client = RecombeeAPIClient.getClient();
    
    static {
    	logger.addHandler(FacadeUtil.getDefaultFileHandler());
    }
    
    /**
     * Get simple user-based recommendations.
     * 
     * @param userId target chatid of the user
     * @param count number of recommendations
     * @return list of items id
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON  })
    @Path("user/{userId}/{count}")
    public List<String> getRecommendationByUserId(@PathParam("userId") String userId,
    											@PathParam("count") long count) {
    	logger.info("getRecommendationByUserId: " + userId 
									+ " " + Long.toString(count));
    	List<String> result = new ArrayList<>(); 
    	Recommendation [] recs = null;
    	try {
    		 recs = client.send(new UserBasedRecommendation(userId, count));
    		 for (Recommendation r: recs) {
    			 result.add(r.getId());
    		 }
		} catch (ApiException e) {
			e.printStackTrace();
			logger.info("Couldn't get user based recommendation from the Recombee!");
			logger.info(e.getMessage());
		}
		return result;   	
    }
    
    
    /**
     * Get simple item-based recommendations.
     * 
     * @param itemId if the given item
     * @param count number of recommendations
     * @return list of items id
     */
    @GET
    @Produces({ MediaType.APPLICATION_JSON  })
    @Path("item/{itemId}/{count}")
    public List<String> getRecommendationByItemId(@PathParam("itemId") String itemId,
    											@PathParam("count") long count) {
    	logger.info("getRecommendationByItemId: " + itemId 
											+ " " + Long.toString(count));
    	List<String> result = new ArrayList<>(); 
    	Recommendation [] recs = null;
    	try {
    		 recs = client.send(new ItemBasedRecommendation(itemId, count));
    		 for (Recommendation r: recs) {
    			 result.add(r.getId());
    		 }
		} catch (ApiException e) {
			e.printStackTrace();
			logger.info("Couldn't get item based recommendation from the Recombee!");
			logger.info(e.getMessage());
		}  	
        return result;
    }

    /**
     * Get simple item-based recommendations.
     * 
     * @param itemId if the given item
     * @param targetUserId is target user for which we are requesting a recommendation
     * @param count number of recommendations
     * @return list of items id
     */
    @GET
    @Produces({ MediaType.APPLICATION_JSON  })
    @Path("user/{userId}item/{itemId}/{count}")
    public List<String> getRecommendationByItemIdTargetUser(@PathParam("userId") String targetUserId,
    											@PathParam("itemId") String itemId,
    											@PathParam("count") long count) {
    	logger.info("getRecommendationByItemId: " + itemId 
											+ " " + Long.toString(count));
    	List<String> result = new ArrayList<>(); 
    	Recommendation [] recs = null;
    	try {
    		 recs = client.send(new ItemBasedRecommendation(itemId, count)
    				 .setTargetUserId(targetUserId));
    		 for (Recommendation r: recs) {
    			 result.add(r.getId());
    		 }
		} catch (ApiException e) {
			e.printStackTrace();
			logger.info("Couldn't get item based recommendation from the Recombee!");
			logger.info(e.getMessage());
		}  	
        return result;
    }
    
    
    
    
}
