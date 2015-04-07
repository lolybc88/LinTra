
		package javaMMinJava;
		
		import blackboard.IdentifiableElement;
		import java.io.Serializable;
	
		public abstract class AbstractTypeDeclaration  extends BodyDeclaration implements Serializable, IdentifiableElement {
			
			private static final long serialVersionUID = 1L;
			
			
			
			
			
			
			BodyDeclaration bodyDeclarations; Boolean bodyDeclarationsIsComposed = true;
			
			Comment commentsBeforeBody; Boolean commentsBeforeBodyIsComposed = true;
			
			Comment commentsAfterBody; Boolean commentsAfterBodyIsComposed = true;
			
			Package package_; Boolean packageIsComposed = false;
			
			TypeAccess superInterfaces; Boolean superInterfacesIsComposed = true;
			
			
			public AbstractTypeDeclaration(){ }
			
			
			public AbstractTypeDeclaration(
				
				String name,				Boolean proxy
				,
				Comment comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile,				ImportDeclaration usagesInImports,				AbstractTypeDeclaration abstractTypeDeclaration,				Annotation annotations,				AnonymousClassDeclaration anonymousClassDeclarationOwner,				Modifier modifier,				TypeAccess usagesInTypeAccess,				BodyDeclaration bodyDeclarations,				Comment commentsBeforeBody,				Comment commentsAfterBody,				Package package_,				TypeAccess superInterfaces ){
				
		super(name, proxy, comments, originalCompilationUnit,
				originalClassFile, usagesInImports, abstractTypeDeclaration,
				annotations, anonymousClassDeclarationOwner, modifier,
				usagesInTypeAccess);
				
				
				
				
				
				this.bodyDeclarations = bodyDeclarations ;
				this.commentsBeforeBody = commentsBeforeBody ;
				this.commentsAfterBody = commentsAfterBody ;
				this.package_ = package_ ;
				this.superInterfaces = superInterfaces ;
			}
			
			
			
			
			
			
			
			public void setBodyDeclarations(BodyDeclaration bodyDeclarations) {
				this.bodyDeclarations = bodyDeclarations;
			}
				
			public BodyDeclaration getBodyDeclarations() {
				return bodyDeclarations;
			}
			
			public void setCommentsBeforeBody(Comment commentsBeforeBody) {
				this.commentsBeforeBody = commentsBeforeBody;
			}
				
			public Comment getCommentsBeforeBody() {
				return commentsBeforeBody;
			}
			
			public void setCommentsAfterBody(Comment commentsAfterBody) {
				this.commentsAfterBody = commentsAfterBody;
			}
				
			public Comment getCommentsAfterBody() {
				return commentsAfterBody;
			}
			
			public void setPackage(Package package_) {
				this.package_ = package_;
			}
				
			public Package getPackage() {
				return package_;
			}
			
			public void setSuperInterfaces(TypeAccess superInterfaces) {
				this.superInterfaces = superInterfaces;
			}
				
			public TypeAccess getSuperInterfaces() {
				return superInterfaces;
			}
			
		}
	