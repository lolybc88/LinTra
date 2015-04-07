
		package javaMMinJava;
		
		import blackboard.IdentifiableElement;
		import java.io.Serializable;
	
		public  class ArrayAccess  extends Expression implements Serializable, IdentifiableElement {
			
			private static final long serialVersionUID = 1L;
			
			String id, trgId;
			
			
			
			
			Expression array; Boolean arrayIsComposed = true;
			
			Expression index; Boolean indexIsComposed = true;
			
			
			public ArrayAccess(){ }
			
			
			public ArrayAccess(
				String id,				
				,
				Comment comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile,				Expression array,				Expression index ){
				
				super(				,
				comments
				,				originalCompilationUnit
				,				originalClassFile
);
				
				this.id = id;
				
				
				
				this.array = array ;
				this.index = index ;
			}
			
			
			
			public String getId() {
   				return id;
			}

			public void setId(String id) {
   				this.id = id;
			}
			
			public String getTrgId() {
   				return trgId;
			}

			public void setTrgId(String trgId) {
   				this.trgId = trgId;
			}
			
			
			
			
			
			public void setArray(Expression array) {
				this.array = array;
			}
				
			public Expression getArray() {
				return array;
			}
			
			public void setIndex(Expression index) {
				this.index = index;
			}
				
			public Expression getIndex() {
				return index;
			}
			
		}
	