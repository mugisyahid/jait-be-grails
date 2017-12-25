import groovy.transform.CompileStatic

@CompileStatic
enum Status {
    ACTIVE('active'),
    DELETED('deleted')



    String display
    Status (String display){
        this.display = display
    }
}
