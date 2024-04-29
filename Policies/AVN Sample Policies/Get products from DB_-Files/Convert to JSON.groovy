import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
 
def invoke(msg)        
{
	// Get the result from the 'Read from Database' filter. 
	// By default, the result is placed in an attribute named 'user'
	def db_result = msg.get('user');
	
	// Instantiate an ObjectMapper
	def mapper = new ObjectMapper();
 
	try {
		// invoke the mapper to do the conversion
		def json_result = mapper.writeValueAsString(db_result);
 
		// Place the json_result onto the message whiteboard
		msg.put('json_result', json_result);
 
		return true;
	} catch (Exception e) {
		msg.put('json_convert_error', e.getMessage());
		return false;
	}
}