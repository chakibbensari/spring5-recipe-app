package guru.springframework.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class LoadData implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    @Transactional
    // @Transactional ensure us to use the same hibernate session and avoid lazyFetch problems
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.debug("Loading initial data ..");
    }
}
