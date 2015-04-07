
		package javaMMinJava;
		
		import blackboard.IdentifiableElement;
		import java.io.Serializable;
	
		public  class VariableDeclarationExpression  extends Expression implements Serializable, IdentifiableElement {
			
			private static final long serialVersionUID = 1L;
			
			String id, trgId;
			
			
			
			
			Modifier modifier; Boolean modifierIsComposed = true;
			
			Annotation annotations; Boolean annotationsIsComposed = true;
			
			
			public VariableDeclarationExpression(){ }
			
			
			public VariableDeclarationExpression(
				String id,				
				,
				Comment comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile,				TypeAccess type,				VariableDeclarationFragment fragments,				Modifier modifier,				Annotation annotations ){
				
				super(				,
				comments
				,				originalCompilationUnit
				,				originalClassFile
				,				type
				,				fragments
);
				
				this.id = id;
				
				
				
				this.modifier = modifier ;
				this.annotations = annotations ;
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
			
			
			
			
			
			public void setModifier(Modifier modifier) {
				this.modifier = modifier;
			}
				
			public Modifier getModifier() {
				return modifier;
			}
			
			public void setAnnotations(Annotation annotations) {
				this.annotations = annotations;
			}
				
			public Annotation getAnnotations() {
				return annotations;
			}
			
		}
	