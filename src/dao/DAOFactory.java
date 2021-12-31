package dao;

import dao.custom.impl.CourseDAOImpl;
import dao.custom.impl.QuaryDaoImpl;
import dao.custom.impl.StudentCoursesImpl;
import dao.custom.impl.StudentDAOIMPL;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory() {

    }

    public static DAOFactory getDaoFactory() {

        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;

    }


    public SuperDAO getDAO(DAOTypes types) {
        switch (types) {
            case STUDENT:
                return new StudentDAOIMPL();

            case COURSE:
                return new CourseDAOImpl();

            case STUDENTCOURSE:
                return new StudentCoursesImpl();

            case QUARYDAO:
                return new QuaryDaoImpl();


            default:
                return null;
        }
    }

    public enum DAOTypes {
        STUDENT, COURSE, STUDENTCOURSE, QUARYDAO
    }
}
