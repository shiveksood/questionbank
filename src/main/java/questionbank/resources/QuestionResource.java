package questionbank.resources;

import questionbank.ResourceBase;
import questionbank.pojo.Question;
import questionbank.service.QuestionService;

import javax.ws.rs.*;

@Path("question")
@Produces("application/json")
@Consumes("application/json")
public class QuestionResource extends ResourceBase {


    @GET
    @Path("{qid}")
    public Question getQuestionResource(@PathParam("qid") int qid) {
        QuestionService questionService = new QuestionService();
        return questionService.getQuestionWithId(qid);
    }

    @POST
    public Question createNewQuestion(Question question) {
        QuestionService questionService = new QuestionService();
        return questionService.addNewQuestion(question);
    }


}
