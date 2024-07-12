//public class UserServices implements userservices{
//    try{
//        Validator validator=validatorFactory.getValidator(ProjectConstants.USER_VALIDATOR);
//        validator.requestValidation(User);
//        if(Strings.isEmpty(user.getUserName)){
//
//        }
//    }
//
//    catch (RequestValidationException requestValidationException){
//        log.error("Exception Requested Validation"+requestValidationException.getMessage());
//        return responseGenerator.createFailedResponse(user,requestValidationException.getErrorCode(),requestValidationException.getErrorMEssage());
//
//    }
//    catch(Exception e){
//        log.error("UnExpected Excption"+e.getMessage());
//        return responseGenerator.createFailedResponse(user,ERR_002.name(),ErrorCodes.ERR_002.getValue());
//
//    }
//    public USerResponse deleteUser(int Id){
//        return respoonseGenerator.createFailedResponse((User) null,ErrorCodes.ERR_003.name(),ERRCodes.ERR_003.getValue());
//
//    }
//    return null;
//    public List<User> getAllUsers(){
//        return userRepository.findAll();
//    }
//}