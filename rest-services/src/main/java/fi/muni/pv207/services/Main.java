package fi.muni.pv207.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import io.dropwizard.Application;
import io.dropwizard.jersey.setup.JerseyEnvironment;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * @author Pavol Loffay
 */
public class Main extends Application<AppConfiguration> {

    public static void main(String[] args) throws Exception {
        Main app = new Main();
        app.run(args);
    }

    @Override
    public void initialize(Bootstrap<AppConfiguration> bootstrap) {
    }

    @Override
    public void run(AppConfiguration configuration, Environment environment) throws Exception {
        // json
        configureObjectMapper(environment.getObjectMapper());

        // rest configuration
        addRestServices(environment.jersey(), configuration);
    }

    private void addRestServices(JerseyEnvironment jerseyEnvironment, AppConfiguration configuration) {
        final EmailService restPing = new EmailService();
        jerseyEnvironment.register(restPing);
    }

    @Override
    public String getName() {
        return "WanderaNotificationService";
    }

    public static void configureObjectMapper(ObjectMapper mapper) {
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.disable(SerializationFeature.WRITE_NULL_MAP_VALUES);
        mapper.disable(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS);
//        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY); // skip false :(
        mapper.enable(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS);
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }
}
