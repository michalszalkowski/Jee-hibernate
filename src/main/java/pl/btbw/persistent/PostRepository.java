package pl.btbw.persistent;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
@LocalBean
public class PostRepository {

//	@PersistenceContext(unitName = "ExampleDS")
	@PersistenceContext(unitName = "ExamplePgDS")
	private EntityManager em;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(Post post) {
		em.persist(post);
	}

	public List<Post> all() {
		Query query = em.createNamedQuery("Post.all");
		return (List<Post>) query.getResultList();
	}

}
