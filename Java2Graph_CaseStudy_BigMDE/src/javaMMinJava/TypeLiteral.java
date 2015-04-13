
		package javaMMinJava;
		
		import blackboard.IdentifiableElement;
		import java.io.Serializable;
	
		public  class TypeLiteral  extends Expression implements Serializable, IdentifiableElement {
			
			private static final long serialVersionUID = 1L;
			
			String id, trgId;
			
			
			
			
			TypeAccess type; Boolean typeIsComposed = true;
			
			
			public TypeLiteral(){ }
			
			
			public TypeLiteral(
				String id,				
				
				Comment[] comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile,				TypeAccess type ){
				
				super(				
				comments
				,				originalCompilationUnit
				,				originalClassFile
);
				
				this.id = id;
				
				
				
				this.type = type ;
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
			
			
			
			
			
			public void setType(TypeAccess type) {
				this.type = type;
			}
				
			public TypeAccess getType() {
				return type;
			}
			
		}
	