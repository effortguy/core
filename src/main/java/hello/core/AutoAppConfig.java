package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan (
        basePackages = "hello.core",
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    //Spring
    // Overriding bean definition for bean 'memoryMemberRepository' with a different definition: replacing [Generic bean: class [hello.core.member.MemoryMemberRepository]; scope=singleton; abstract=false; lazyInit=null; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodName=null; destroyMethodName=null; defined in file [D:\test_project\core\out\production\classes\hello\core\member\MemoryMemberRepository.class]] with [Root bean: class [null]; scope=; abstract=false; lazyInit=null; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=autoAppConfig; factoryMethodName=memberRepository; initMethodName=null; destroyMethodName=(inferred); defined in hello.core.AutoAppConfig]

    //Spring Boot
    // The bean 'memoryMemberRepository', defined in class path resource [hello/core/AutoAppConfig.class], could not be registered. A bean with that name has already been defined in file [D:\test_project\core\out\production\classes\hello\core\member\MemoryMemberRepository.class] and overriding is disabled.
    //
    //Action:
    //
    //Consider renaming one of the beans or enabling overriding by setting spring.main.allow-bean-definition-overriding=true
    @Bean("memoryMemberRepository")
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
