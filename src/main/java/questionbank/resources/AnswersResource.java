package questionbank.resources;

import questionbank.ResourceBase;
import questionbank.pojo.Answer;
import questionbank.service.AnswersService;

import javax.ws.rs.*;

@Path("answers")
@Produces("application/json")
@Consumes("application/json")
public class AnswersResource extends ResourceBase {

    @Path("{qid}")
    public Answer getAnswerWithID(@PathParam("qid") int qid){
        AnswersService answersService = new AnswersService();
        return answersService.getAnswerById(qid);
    }

    @POST
    public Answer createNewAnswer(Answer answer){
        AnswersService answersService = new AnswersService();
        return answersService.createAnswer(answer);
    }

}
