package questionbank.resources;


import questionbank.ResourceBase;
import questionbank.pojo.Category;
import questionbank.service.CategoryService;

import javax.ws.rs.*;

@Path("category")
@Produces("application/json")
@Consumes("application/json")
public class CategoryResource extends ResourceBase {

    private CategoryService categoryService = new CategoryService();

    @GET
    @Path("{catid}")
    public Category getCategories(@PathParam("catid") int catid) {
        return categoryService.getCategory(catid);
    }

    @POST
    public Category createNewCategory(Category category) {
        return categoryService.createCategory(category);
    }
}
