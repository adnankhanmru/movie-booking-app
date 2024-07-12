//package com.example.movie_booking.service;
//
//
//
//import Repsoitory.MovieRepository;
//
//public class MovieServices{
//
//    public MovieService addMovie(Thratre theatre){
//
//        try{
//
//            Validator validator=validatorFactory.getValidator(ProjectConstants,MovieServices);
//
//        }
//
//        catch(Exceptionn e){
//
//            return responseGenerator.createFailedResponse(movie,ErrorCodes.ERR_002.name(),ERR_002.getValue());
//
//        }
//
//    }
//
//    void bookMovie(){}
//
//    public MovieRepository addMovie(TheatreRequest theatreRequest){
//
//        try{
//
//            if(theatreRequest.getMovieID()==0){
//
//                return responseGenerator.createFailedResponse(theatreRequest.getMovieID());
//
//            }
//
//            Movie movie=MovieRespository.getById(TheatreRequest.getMovieId());
//
//            if(Objects.notnull(movie)) {
//
//                List<Movie> movieList = createMovieState(theatreRequest);
//
//                movieStateRepository.saveall(movieList);
//
//                responseGenerator.createSuccessResponse(theatreRequest.getMovieID(), "Movie State Added Successfully");
//
//            }
//
//            else return responseGenerator.createFailedResponse(theatreRequest.getMovieId(),ErrorCodes.ERR_005.name(),ErrorCodes.ERR_005.getValue());
//
//        }
//
//        catch (Excpetion e){}
//
//        return null;
//
//    }
//
//    private List<MovieServices> createMovieState(TheatreRequest theatreRequest){
//
//        List<String> time = theatreRequest.getTime();
//
//        List<String> city = theatreRequest.getTime();
//
//        List<string> movieStates=new ArrayList<>();
//
//        for(int i=0;i<time.size();i++){
//
//            for(int j=0;j<city.size();j++){
//
//                movieStates.add(MovieStates.builder().date(theatreRequest.getDate()).time(time.get(i)));
//
//        .movieName(theatreRequest.getMovieName());
//
//        .theatreState(theatreRequest.getTheatreName());
//
//        .city(city.get(j)).duration(theatreRequest.getDuration());
//
//        .movieID(theatreRequest.getMovieID()).build());
//
//            }
//
//        }
//
//        return movieStates;
//    }
//
//    void updateMovieStates(){}
//
//}