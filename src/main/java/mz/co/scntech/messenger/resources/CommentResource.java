
package mz.co.scntech.messenger.resources;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import mz.co.scntech.messenger.dao.CommentDAO;
import mz.co.scntech.messenger.model.Comment;

/**
 *
 * @author Sidónio Goenha on Aug 24, 2020
 *
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {

	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long messageId) {
		// return commentService.getAllComments(messageId);
		return CommentDAO.findAll(Comment.class);
	}

	@GET
	@Path("/{commentId}")
	public Comment getComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
		// return commentService.getComment(messageId, commentId);
		return CommentDAO.getComment(messageId, commentId);
	}

	@POST
	public Comment addMessage(@PathParam("messageId") long messageId, Comment comment) {
		// return commentService.addComment(messageId, comment);
		return CommentDAO.addComment(messageId, comment);
	}

	@PUT
	@Path("/{commentId}")
	public Comment updateComment(@PathParam("messageId") long messageId, @PathParam("commentId") long id,
			Comment comment) {
		comment.setId(id);
		// return commentService.updateComment(messageId, comment);
		return CommentDAO.updateComment(messageId, comment);
	}

	@DELETE
	@Path("/{commentId}")
	public void deleteComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
		// commentService.removeComment(messageId, commentId);
		CommentDAO.removeComment(messageId, commentId);
	}
}
