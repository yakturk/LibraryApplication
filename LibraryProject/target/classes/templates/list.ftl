<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Library Application</span></div>
        <div class="panel-body">
            <div class="formcontainer">
                <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
                <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
                <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                    <input type="hidden" ng-model="ctrl.book.id" />
                    <br>
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="uname">Name</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.book.name" id="uname" class="bookname form-control input-sm" placeholder="Enter books name" required ng-minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="authorname">AuthorName</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.book.authorname" id="authorname" class="form-control input-sm" placeholder="Enter Authors Name." required ng-minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="form-actions floatRight">
                            <input type="submit"  value="{{!ctrl.book.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
                            <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" >Reset Form</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <br><br><br>
        <div class="panel-heading"><span class="lead">List of Book</span></div>
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>NAME</th>
                        <th>AUTHOR</th>
                        <th width="100"></th>
                        <th width="100"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="u in ctrl.getAllBooks()">
                        <td>{{u.id}}</td>
                        <td>{{u.name}}</td>
                        <td>{{u.authorname}}</td>
                        <td><button type="button" ng-click="ctrl.editBook(u.id)" class="btn btn-success custom-width">Edit</button></td>
                        <td><button type="button" ng-click="ctrl.removeBook(u.id)" class="btn btn-danger custom-width">Remove</button></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>