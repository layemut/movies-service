package tr.com.layemut.moviesservice.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;


@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

    @Override
    public MongoClient mongoClient() {

        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        return new MongoClient("188.166.96.177", MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
    }

    @Override
    protected String getDatabaseName() {
        return "MAINDB";
    }
}
