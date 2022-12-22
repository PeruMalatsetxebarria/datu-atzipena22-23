package dambi.rest_mongo_pelikulak.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;


import static com.mongodb.client.model.Filters.eq;

@Repository
public class MongoDBPelikulaRepository implements PelikulaRepository {

    private static final TransactionOptions txnOptions = TransactionOptions.builder()
                                                                           .readPreference(ReadPreference.primary())
                                                                           .readConcern(ReadConcern.MAJORITY)
                                                                           .writeConcern(WriteConcern.MAJORITY)
                                                                           .build();
    @Autowired
    private MongoClient client;
    private MongoCollection<Pelikula> pelikulaCollection;

    @PostConstruct
    void init() {
        pelikulaCollection = client.getDatabase("pelikulak").getCollection("filmoteka", Pelikula.class);
    }

    @Override
    public List<Pelikula> findAll() {
        return pelikulaCollection.find().into(new ArrayList<>());
    }

    @Override
    public Pelikula findById(String id) {
        return pelikulaCollection.find(eq("_id", new ObjectId(id))).first();        
    }

    @Override
    public Pelikula findByYear(String id) {
        return pelikulaCollection.find(eq("year", new ObjectId(id))).first();        
    }

    @Override
    public Pelikula findByActor(String id) {
        return pelikulaCollection.find(eq("cast", new ObjectId(id))).first();        
    }

    @Override
    public Pelikula findByZuzendari(String id) {
        return pelikulaCollection.find(eq("director", new ObjectId(id))).first();        
    }

    @Override
    public List<Pelikula> findByZuzendaria() {
        return pelikulaCollection.find(eq("director")).into(new ArrayList<>());
    }

    @Override
    public Pelikula save(Pelikula pelikula) {
        pelikula.setId(new ObjectId());
        pelikulaCollection.insertOne(pelikula);
        return pelikula;
    }

    @Override
    public long delete(String title) {
        return pelikulaCollection.deleteMany(eq("title", title)).getDeletedCount();
    }

}
