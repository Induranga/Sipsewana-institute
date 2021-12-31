package bo;

import bo.custom.impl.ManageCourseBOImpl;
import bo.custom.impl.StudentBOImpl;
import dao.custom.impl.StudentCoursesImpl;
import entity.StudentCourses;

public class BoFactory {

        private static BoFactory boFactory;
        private BoFactory() {
        }
        public static BoFactory getBOFactory() {
            if (boFactory == null) {
                boFactory = new BoFactory();
            }
            return boFactory;
        }
        public SuperBO getBO(BoTypes types) {
            switch (types) {
                case STUDENT:
                    return new StudentBOImpl();
                case COURSE:
                    return new ManageCourseBOImpl();


                default:
                    return null;
            }
        }
        public enum BoTypes {
            STUDENT,COURSE

    }
}
