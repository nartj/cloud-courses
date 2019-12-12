package com.utbm.lo54.backend.controller.helper;//package com.utbm.lo54.jcourses.controller.helper;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.io.Serializable;
//import java.util.List;
//import java.util.Objects;
//
//@Component
//public class ModelHelper {
//
//    @Autowired
//    private LocationService locationService;
//    @Autowired
//    private CourseService courseService;
//
//    private List<Course> courses;
//    private List<Location> locations;
//
//    public CourseSessionModel getCourseSessionModel(CourseSession courseSession) {
//        getLists();
//        return new CourseSessionModel(courseSession, courses, locations);
//    }
//
//    private void getLists() {
//        courses = courseService.getCourses();
//        locations = locationService.getLocations();
//    }
//
//    public static class CourseSessionModel implements Serializable {
//        private CourseSession courseSession;
//        private List<Course> courses;
//        private List<Location> locations;
//
//        public CourseSessionModel() { }
//
//        CourseSessionModel(CourseSession courseSession, List<Course> courses, List<Location> locations) {
//            this.courseSession = courseSession;
//            this.courses = courses;
//            this.locations = locations;
//        }
//
//        public CourseSession getCourseSession() {
//            return courseSession;
//        }
//
//        public CourseSessionModel setCourseSession(CourseSession courseSession) {
//            this.courseSession = courseSession;
//            return this;
//        }
//
//        public List<Course> getCourses() {
//            return courses;
//        }
//
//        public CourseSessionModel setCourses(List<Course> courses) {
//            this.courses = courses;
//            return this;
//        }
//
//        public List<Location> getLocations() {
//            return locations;
//        }
//
//        public CourseSessionModel setLocations(List<Location> locations) {
//            this.locations = locations;
//            return this;
//        }
//
//        @Override
//        public String toString() {
//            return "CourseSessionModel{" +
//                    "courseSession=" + courseSession +
//                    ", courses=" + courses +
//                    ", locations=" + locations +
//                    '}';
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            CourseSessionModel that = (CourseSessionModel) o;
//            return Objects.equals(courseSession, that.courseSession) &&
//                    Objects.equals(courses, that.courses) &&
//                    Objects.equals(locations, that.locations);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(courseSession, courses, locations);
//        }
//    }
//}
